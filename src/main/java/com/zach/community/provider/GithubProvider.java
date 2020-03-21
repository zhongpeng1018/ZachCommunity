package com.zach.community.provider;

import com.alibaba.fastjson.JSON;
import com.zach.community.dto.GithubDTO;
import com.zach.community.dto.GithubUser;
import com.zach.community.utils.ResponseBodyAnalysis;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @author zach - 吸柒
 */
@Component
public class GithubProvider {

    private String oauthUrl = "https://github.com/login/oauth/access_token";

    private String userUrl = "https://api.github.com/user";

    private OkHttpClient client = new OkHttpClient();


    /**
     * 获取 access_token
     *
     * @param githubDTO
     * @return
     */
    public String getAccessToken(GithubDTO githubDTO) {

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        String json = JSON.toJSONString(githubDTO);

        RequestBody body = RequestBody.create(mediaType, json);

        Request request = new Request.Builder()
                .url(oauthUrl)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            ResponseBodyAnalysis responseBodyAnalysis = new ResponseBodyAnalysis();

            Map<String, String> map = responseBodyAnalysis
                    .parseResponseBody(response.body().string());

            String accessToken = map.get("access_token");

            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public GithubUser getGithubUser(String accessToken) {

        Request request = new Request.Builder()
                .url(userUrl + "?access_token=" + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return JSON.parseObject(response.body().string(), GithubUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
