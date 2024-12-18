package com.rosenzest.rest.client;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.rosenzest.rest.client.annotation.Api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.net.url.UrlBuilder;

/**
 * 抽象可编辑URI 接口
 * 
 * @author fronttang
 * @date 2021/08/26
 */
public abstract class AbstractEditableUriApi<PARAM, RESULT> extends AbstractApi<PARAM, RESULT>
    implements InitializingBean {

    /**
     * 接口PATH
     */
    protected String path;

    /**
     * 接口HOST
     */
    protected String host;

    /**
     * 请求方式
     */
    protected HttpMethod method;

    /**
     * 处理URI
     * 
     * @param param
     * @return
     */
    protected URI getRequestUri(PARAM param) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        UrlBuilder builder = UrlBuilder.of(this.host);

        uriBuilder.scheme(builder.getScheme());
        uriBuilder.host(builder.getHost());
        uriBuilder.port(builder.getPort());
        uriBuilder.path(path);
        uriBuilder.uriVariables(uriVariables(param));

        Map<String, Object> queryParam = queryParam(param);
        if (MapUtil.isNotEmpty(queryParam)) {
            queryParam.forEach((key, value) -> {
                uriBuilder.queryParam(key, value);
            });
        }

        return uriBuilder.build().toUri();
    }

    /**
     * PATH VARIABLE
     * 
     * @param param
     * @return
     */
    protected Map<String, Object> uriVariables(PARAM param) {
        if (Objects.nonNull(param)) {
            return BeanUtil.beanToMap(param);
        }
        return MapUtil.newHashMap();
    }

    /**
     * 查询条件,拼接在URL后面
     * 
     * @param param
     * @return
     */
    protected Map<String, Object> queryParam(PARAM param) {
        return MapUtil.newHashMap();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    /**
     * 初始化操作
     */
    public void init() {
        Api api = AnnotatedElementUtils.findMergedAnnotation(getClass(), Api.class);
        this.host = api.host();
        this.path = api.path();
        this.method = api.method();
    }

}
