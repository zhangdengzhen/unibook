package dengzhenzhang.top.unibook_back.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import dengzhenzhang.top.unibook_back.dao.WeChat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(tags = "登录")
@RequestMapping("wechat")
public class WeChatController {

    @Value("${wx.mp.appid}")
    private String appid;
    @Value("${wx.mp.appSecret}")
    private String appSecret;

    @ApiOperation(value = "登录")
    @GetMapping("/login")
    @ResponseBody
    WeChat getcode(@RequestParam String code){
        String url =  "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+appSecret+"&js_code="+code+"&grant_type=authorization_code";
        String content = HttpUtil.get(url);

//        openid: "o0Wb75dvbH9XhnPseDNj2ouLrBnk"
//        session_key: "jRi6287BaBablQjXJp4ITg=="
//        unionid: "o82cg54l6uUgOxL1DfjDhgbTOwKU"
        JSONObject jsonObject = JSONUtil.parseObj(content);
        String openid = jsonObject.getStr("openid");
        String session_key = jsonObject.getStr("session_key");
        String unionid = jsonObject.getStr("unionid");
        WeChat weChat = new WeChat();
        weChat.setOpenid(openid);
        weChat.setSession_key(session_key);
        weChat.setUnionid(unionid);
        return weChat;
    }

}
