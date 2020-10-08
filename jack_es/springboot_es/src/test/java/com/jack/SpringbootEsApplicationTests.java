package com.jack;

import com.alibaba.fastjson.JSON;
import com.jack.entity.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootEsApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    //测试索引的创建 Request
    @Test
    void testCreateIndex() throws IOException {
        //1. 创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("jack_index");
        //2. 客户端执行请求,请求后，获得响应
        CreateIndexResponse response = restHighLevelClient.indices()
                .create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    //测试判断索引是否存在
    @Test
    void testExistIndex() throws IOException {
        //1. 获取索引请求
        GetIndexRequest request = new GetIndexRequest("jack");
        boolean exists = restHighLevelClient.indices()
                .exists(request, RequestOptions.DEFAULT);
        if(exists){
            System.out.println("获取的索引存在");
        }else{
            System.out.println("获取的索引不存在");
        }
    }

    //测试删除索引
    @Test
    void testDeleteIndex() throws IOException {
        //1. 获取删除索引请求
        DeleteIndexRequest request =  new DeleteIndexRequest("jack_index");
        //2. 客户端执行请求，返回响应结果
        AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);

        System.out.println(response.isAcknowledged());
    }

    //测试添加文档
    @Test
    void testAddDocument() throws IOException {
        //1. 创建对象
        User user = new User("jack", 23, "男");
        //2. 创建请求
        IndexRequest jack_index = new IndexRequest("jack_index");

        //3. 规则 PUT /jack_index/_doc/1
        //不指定类型，默认类型是_doc
        jack_index.id("1");//文档id
        jack_index.timeout(TimeValue.timeValueSeconds(1)); //设置超时时间
        //4. 将数据放入请求 JSON
        jack_index.source(JSON.toJSONString(user), XContentType.JSON);
        //5. 客户端发送请求, 获取响应结果
        IndexResponse response = restHighLevelClient
                .index(jack_index, RequestOptions.DEFAULT);

        System.out.println(response.toString());//信息返回
        System.out.println(response.status());//命令返回状态
    }

    //测试判断文档是否存在
    @Test
    void testIsExists() throws IOException {
        GetRequest jack_index = new GetRequest("jack_index", "1");

        //不获取返回的 _source的上下文
        jack_index.fetchSourceContext(new FetchSourceContext(false));
        jack_index.storedFields("_none_");

        boolean exists = restHighLevelClient.exists(jack_index, RequestOptions.DEFAULT);

        System.out.println(exists);
    }

    //测试获取某一个文档信息
    @Test
    void testGetDocument() throws IOException {
        GetRequest jack_index = new GetRequest("jack_index", "1");
        GetResponse response = restHighLevelClient.get(jack_index, RequestOptions.DEFAULT);

        System.out.println(response.getSourceAsString()); //打印文档的内容
        System.out.println(response); //返回的全部内容和命令一样的
    }

    //测试更新文档信息
    @Test
    void testUpdateDocument() throws IOException {
        //获取更新请求
        UpdateRequest updateRequest = new UpdateRequest("jack_index", "1");
        //设置更新超时时间
        updateRequest.timeout("1s");

        User user = new User("小杰", 22, "男");
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);
        //执行
        UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse.status());//这个是状态
    }

    //测试删除文档
    @Test
    void testDeleteDocument() throws IOException {
        //获取删除请求
        DeleteRequest deleteRequest = new DeleteRequest("jack_index", "1");
        //设置删除超时时间
        deleteRequest.timeout("1s");
        //执行
        DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(delete.status());
    }

    //特殊情况，批量插入数据
    @Test
    void testBulkRequest() throws IOException {
        //通过BulkRequest来进行批量操作
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        List<User> users = new ArrayList<>();
        users.add(new User("张三", 16, "男"));
        users.add(new User("李四", 25, "男"));
        users.add(new User("王五", 30, "男"));
        users.add(new User("王昭君", 20, "男"));
        users.add(new User("貂蝉", 22, "男"));

        Integer i = 1;
        for(User user : users){
            bulkRequest.add(new IndexRequest("jack_index")
                    .id((i++).toString())
                    .source(JSON.toJSONString(user),XContentType.JSON));
        }

        //批处理
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.hasFailures()); //是否失败，返回false代表成功
    }

    //测试查询
    @Test
    void testSearch() throws IOException {
        //1. 获取搜索请求
        SearchRequest jack_index = new SearchRequest("jack_index");

        //2. 构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置查询条件 (查询名字含有王的User)，使用QueryBuilders快速精确匹配
        TermQueryBuilder termQuery = QueryBuilders.termQuery("name", "王");
        sourceBuilder.query(termQuery);

        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        jack_index.source(sourceBuilder);//搜索请求执行的搜索条件，装载

        //3. 执行
        SearchResponse search = restHighLevelClient.search(jack_index, RequestOptions.DEFAULT);
        //System.out.println(JSON.toJSONString(search.getHits().getHits()));
        //遍历    查询的结果会封装到getHits中
        for(SearchHit documentFields : search.getHits()){
            System.out.println(documentFields.getSourceAsMap());
        }
    }

    //测试全部查询
    @Test
    void testQueryAll() throws IOException {
        //1. 获取搜索请求
        SearchRequest searchRequest = new SearchRequest("jack_index");
        //2. 构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置查询条件 matchAllQuery查询所有文档
        MatchAllQueryBuilder allQuery = QueryBuilders.matchAllQuery();
        sourceBuilder.query(allQuery);
        searchRequest.source(sourceBuilder);//搜索请求执行的搜索条件，装载
        //3. 执行
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //遍历    查询的结果会封装到getHits中
        for(SearchHit documentFields : search.getHits()){
            System.out.println(documentFields.getSourceAsMap());
        }
    }
}
