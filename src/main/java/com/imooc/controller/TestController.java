package com.imooc.controller;

import com.imooc.common.JsonUtil;
import com.imooc.model.CheckInfo;
import com.imooc.model.OCRGeneralResult;
import com.imooc.object.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by geely on 2015/11/22.
 */
@Controller
public class TestController {

    //todo     http://localhost:8080/baseType.do?age=10
    //todo 500 http://localhost:8080/baseType.do
    //todo 400 http://localhost:8080/baseType.do?age=abc
    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(int age){
        return "age:"+age;
    }

    //todo     http://localhost:8080/baseType2.do?age=10
    //todo     http://localhost:8080/baseType2.do
    //todo 400 http://localhost:8080/baseType2.do?age=abc
    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age){
        return "age:"+age;
    }

    //todo http://localhost:8080/array.do?name=Tom&name=Lucy&name=Jim
    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] name){
        StringBuilder sbf = new StringBuilder();
        for(String item : name){
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    //todo http://localhost:8080/object.do?name=Tom&age=10
        /* 输出的user和admin都是一样的*/
    //TODO http://localhost:8080/object.do?name=Tom&age=10&contactInfo.phone=10086
         /*实体里面有有一个字段是其他实体的传参情况， 输出的user和admin都是一样的*/
    //TODO http://localhost:8080/object.do?user.name=Tom&admin.name=Lucy&age=10
        /* user：tom、10,  admin：Lucy、10*/
    @RequestMapping(value = "object.do")
    @ResponseBody
    public String object(User user,Admin admin){
        return user.toString()+" "+admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }
    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder){
        binder.setFieldDefaultPrefix("admin.");
    }

    //TODO http://localhost:8080/list.do?users[0].name=Tom&users[1].name=Lucy
    //TODO http://localhost:8080/list.do?users[0].name=Tom&users[1].name=Lucy&users[20].name=Jim
    /*这里就会出现下标为2-19的都是null，list长度是21*/
    @RequestMapping(value = "list.do")
    @ResponseBody
    public String list(UserListForm userListForm){
        return "listSize:"+userListForm.getUsers().size() + "  " + userListForm.toString();
    }

    @RequestMapping(value = "listAndString.do")
    @ResponseBody
    public String listAndString(@RequestBody ListAndString listAndString){
        return "listSize:"+listAndString.getUsers().size() + "  " + listAndString.toString();
    }

    @RequestMapping(value = "form/listAndString.do")
    @ResponseBody
    public String listAndStringByForm(HttpServletRequest request){
        String inputText = request.getParameter("inputText");
        String usersStr = request.getParameter("users");
        List<User> users = JsonUtil.stringToObj(usersStr, List.class, User.class);
        System.out.println("------");
       // return "form listSize:"+listAndString.getUsers().size() + "  " + listAndString.toString();
        return "Hello";
    }

    /**
     * {
     "inputContents": "输入了XXXX",
     "generalResult": "总的内容在此",
     "contrastData": [
     {
     "errorcode": 0,
     "errormsg": "OK",
     "items": [
     {
     "itemstring": "夏天的几鸟，飞到我富的唱教，又飞表了.",
     "itemcoord": {
     "x": 13,
     "width": 125,
     "y": 50,
     "height": 10
     },
     "words": [
     {
     "character": "夏",
     "confidence": 0.5010754
     },
     {
     "character": "天",
     "confidence": 0.7288387
     },
     {
     "character": "的",
     "confidence": 0.99281454
     },
     {
     "character": "几",
     "confidence": 0.3796618
     },
     {
     "character": "鸟",
     "confidence": 0.7355897
     },
     {
     "character": "，",
     "confidence": 0.61523587
     },
     {
     "character": "飞",
     "confidence": 0.91961694
     },
     {
     "character": "到",
     "confidence": 0.9196189
     },
     {
     "character": "我",
     "confidence": 0.90556383
     },
     {
     "character": "富",
     "confidence": 0.7892846
     },
     {
     "character": "的",
     "confidence": 0.6853006
     },
     {
     "character": "唱",
     "confidence": 0.7858696
     },
     {
     "character": "教",
     "confidence": 0.4718861
     },
     {
     "character": "，",
     "confidence": 0.7147656
     },
     {
     "character": "又",
     "confidence": 0.8626015
     },
     {
     "character": "飞",
     "confidence": 0.92070454
     },
     {
     "character": "表",
     "confidence": 0.39385477
     },
     {
     "character": "了",
     "confidence": 0.5780223
     },
     {
     "character": ".",
     "confidence": 0.4801033
     }
     ]
     },
     {
     "itemstring": "秋天的黄时。它们没有什么时部。只双息一声，飞留在那里。",
     "itemcoord": {
     "x": 13,
     "width": 178,
     "y": 68,
     "height": 11
     },
     "words": [
     {
     "character": "秋",
     "confidence": 0.2947411
     },
     {
     "character": "天",
     "confidence": 0.9728084
     },
     {
     "character": "的",
     "confidence": 0.9991223
     },
     {
     "character": "黄",
     "confidence": 0.8168685
     },
     {
     "character": "时",
     "confidence": 0.524826
     },
     {
     "character": "。",
     "confidence": 0.6220701
     },
     {
     "character": "它",
     "confidence": 0.9995515
     },
     {
     "character": "们",
     "confidence": 0.5343065
     },
     {
     "character": "没",
     "confidence": 0.9923568
     },
     {
     "character": "有",
     "confidence": 0.99764997
     },
     {
     "character": "什",
     "confidence": 0.9997055
     },
     {
     "character": "么",
     "confidence": 0.9980951
     },
     {
     "character": "时",
     "confidence": 0.6752878
     },
     {
     "character": "部",
     "confidence": 0.25553057
     },
     {
     "character": "。",
     "confidence": 0.39494115
     },
     {
     "character": "只",
     "confidence": 0.9926267
     },
     {
     "character": "双",
     "confidence": 0.5798727
     },
     {
     "character": "息",
     "confidence": 0.9259638
     },
     {
     "character": "一",
     "confidence": 0.99430203
     },
     {
     "character": "声",
     "confidence": 0.9990608
     },
     {
     "character": "，",
     "confidence": 0.7027071
     },
     {
     "character": "飞",
     "confidence": 0.8253999
     },
     {
     "character": "留",
     "confidence": 0.4620626
     },
     {
     "character": "在",
     "confidence": 0.9915985
     },
     {
     "character": "那",
     "confidence": 0.46774948
     },
     {
     "character": "里",
     "confidence": 0.71466345
     },
     {
     "character": "。",
     "confidence": 0.67014843
     }
     ]
     },
     {
     "itemstring": "Serey tirds of wer com to mywndow to ing an的ey",
     "itemcoord": {
     "x": 11,
     "width": 206,
     "y": 105,
     "height": 10
     },
     "words": [
     {
     "character": "S",
     "confidence": 0.71856946
     },
     {
     "character": "e",
     "confidence": 0.3399169
     },
     {
     "character": "r",
     "confidence": 0.63631976
     },
     {
     "character": "e",
     "confidence": 0.5458487
     },
     {
     "character": "y",
     "confidence": 0.66691184
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "t",
     "confidence": 0.90199065
     },
     {
     "character": "i",
     "confidence": 0.6280823
     },
     {
     "character": "r",
     "confidence": 0.54808384
     },
     {
     "character": "d",
     "confidence": 0.97504276
     },
     {
     "character": "s",
     "confidence": 0.4325953
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "o",
     "confidence": 0.9582367
     },
     {
     "character": "f",
     "confidence": 0.7789338
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "w",
     "confidence": 0.78314316
     },
     {
     "character": "e",
     "confidence": 0.85200375
     },
     {
     "character": "r",
     "confidence": 0.87102604
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "c",
     "confidence": 0.9764223
     },
     {
     "character": "o",
     "confidence": 0.9062224
     },
     {
     "character": "m",
     "confidence": 0.98614967
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "t",
     "confidence": 0.68612653
     },
     {
     "character": "o",
     "confidence": 0.5824866
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "m",
     "confidence": 0.9916653
     },
     {
     "character": "y",
     "confidence": 0.9790627
     },
     {
     "character": "w",
     "confidence": 0.5957824
     },
     {
     "character": "n",
     "confidence": 0.53095746
     },
     {
     "character": "d",
     "confidence": 0.76483923
     },
     {
     "character": "o",
     "confidence": 0.49271008
     },
     {
     "character": "w",
     "confidence": 0.92651117
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "t",
     "confidence": 0.3726204
     },
     {
     "character": "o",
     "confidence": 0.4601365
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "i",
     "confidence": 0.4353082
     },
     {
     "character": "n",
     "confidence": 0.5030557
     },
     {
     "character": "g",
     "confidence": 0.8021885
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "a",
     "confidence": 0.49621612
     },
     {
     "character": "n",
     "confidence": 0.7924712
     },
     {
     "character": "的",
     "confidence": 0.37098572
     },
     {
     "character": "e",
     "confidence": 0.4273843
     },
     {
     "character": "y",
     "confidence": 0.75340605
     }
     ]
     },
     {
     "itemstring": "And wlow baw of wt.m wfichbreno ofte erdte",
     "itemcoord": {
     "x": 11,
     "width": 209,
     "y": 124,
     "height": 10
     },
     "words": [
     {
     "character": "A",
     "confidence": 0.8202195
     },
     {
     "character": "n",
     "confidence": 0.80617553
     },
     {
     "character": "d",
     "confidence": 0.96453243
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "w",
     "confidence": 0.68687004
     },
     {
     "character": "l",
     "confidence": 0.5088897
     },
     {
     "character": "o",
     "confidence": 0.50072116
     },
     {
     "character": "w",
     "confidence": 0.92789227
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "b",
     "confidence": 0.425511
     },
     {
     "character": "a",
     "confidence": 0.33236754
     },
     {
     "character": "w",
     "confidence": 0.80530006
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "o",
     "confidence": 0.9596203
     },
     {
     "character": "f",
     "confidence": 0.8537045
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "w",
     "confidence": 0.7581282
     },
     {
     "character": "t",
     "confidence": 0.7557256
     },
     {
     "character": ".",
     "confidence": 0.42010403
     },
     {
     "character": "m",
     "confidence": 0.9480593
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "w",
     "confidence": 0.4466767
     },
     {
     "character": "f",
     "confidence": 0.28388545
     },
     {
     "character": "i",
     "confidence": 0.6356062
     },
     {
     "character": "c",
     "confidence": 0.3987454
     },
     {
     "character": "h",
     "confidence": 0.49787304
     },
     {
     "character": "b",
     "confidence": 0.3339405
     },
     {
     "character": "r",
     "confidence": 0.36388305
     },
     {
     "character": "e",
     "confidence": 0.9201937
     },
     {
     "character": "n",
     "confidence": 0.49049434
     },
     {
     "character": "o",
     "confidence": 0.86851627
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "o",
     "confidence": 0.36256903
     },
     {
     "character": "f",
     "confidence": 0.5489272
     },
     {
     "character": "t",
     "confidence": 0.4036204
     },
     {
     "character": "e",
     "confidence": 0.38053954
     },
     {
     "character": "",
     "confidence": 1
     },
     {
     "character": "e",
     "confidence": 0.62307966
     },
     {
     "character": "r",
     "confidence": 0.3210712
     },
     {
     "character": "d",
     "confidence": 0.7316087
     },
     {
     "character": "t",
     "confidence": 0.64668643
     },
     {
     "character": "e",
     "confidence": 0.4874326
     }
     ]
     }
     ],
     "session_id": ""
     }
     ]
     }


     * @param checkInfo
     * @return
     */
    @RequestMapping(value = "checkInfo.do")
    @ResponseBody
    public String checkInfo(@RequestBody CheckInfo checkInfo){

        if(checkInfo != null && checkInfo.getContrastData() != null){
            return "listSize:"+ checkInfo.getContrastData().size() + "  " ;
        }
        return "Error";
    }

    @RequestMapping(value = "form/checkInfo.do")
    @ResponseBody
    public String checkInfo(HttpServletRequest request){
        String contrastData = request.getParameter("contrastData");
        String inputContents = request.getParameter("inputContents");
        String generalResult = request.getParameter("generalResult");
        List<OCRGeneralResult> list = JsonUtil.stringToObj(contrastData, ArrayList.class, OCRGeneralResult.class);

        if(list != null){
            return "listSize:"+ list.size() + "  " ;
        }
        return "Error";
    }



    //TODO http://localhost:8080/set.do?users[0].name=Tom&users[1].name=Lucy
        /* size为2*/
    //TODO http://localhost:8080/set.do?users[0].name=Tom&users[20].name=Lucy
        /* size为2，而且因为下标越界而发生报错了*/
    @RequestMapping(value = "set.do")
    @ResponseBody
    public String set(UserSetForm userSetForm){
        return userSetForm.toString();
    }

    //TODO http://localhost:8080/map.do?users['X'].name=Tom&users['X'].age=10&users['Y'].name=Lucy
    @RequestMapping(value = "map.do")
    @ResponseBody
    public String map(UserMapForm userMapForm){
        return userMapForm.toString();
    }


/*    {
        "name": "Jim",
         "age": 16,
         "contactInfo": {
                "address": "beijing",
                "phone": "10010"
           }
    }*/
    //application/json
    @RequestMapping(value = "json.do")
    @ResponseBody
    public String json(@RequestBody User user){
        return user.toString();
    }


/*    <?xml version="1.0" encoding="UTF-8" ?>
    <admin>
      <name>Jim</name>
      <age>16</age>
    </admin>
    */
    //application/xml
    @RequestMapping(value = "xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin){
        return admin.toString();
    }

    @RequestMapping(value = "date1.do")
    @ResponseBody
    public String date1(Date date1){
        return date1.toString();
    }

    @InitBinder("date1")
    public void initDate1(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }

    @RequestMapping(value = "date2.do")
    @ResponseBody
     public String date2(Date date2){
        return date2.toString();
    }



    @RequestMapping(value = "/book",method = RequestMethod.GET)
    @ResponseBody
    public String book(HttpServletRequest request){
        String contentType = request.getContentType();
        if(contentType == null){
            return "book.default";
        }else if(contentType.equals("txt")){
            return "book.txt";
        }else if(contentType.equals("html")){
            return "book.html";
        }
        return "book.default";
    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.GET)
    @ResponseBody
    public String subjectGet(@PathVariable("subjectId") String subjectId){
        return "this is a get method,subjectId:"+subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.POST)
    @ResponseBody
    public String subjectPost(@PathVariable("subjectId") String subjectId){
        return "this is a post method,subjectId:"+subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.DELETE)
    @ResponseBody
    public String subjectDelete(@PathVariable("subjectId") String subjectId){
        return "this is a delete method,subjectId:"+subjectId;
    }

    @RequestMapping(value = "/subject/{subjectId}",method = RequestMethod.PUT)
    @ResponseBody
    public String subjectPut(@PathVariable("subjectId") String subjectId){
        return "this is a put method,subjectId:"+subjectId;
    }













    @RequestMapping(value = "converter.do")
    @ResponseBody
    public String converter(Boolean bool){
        return bool.toString();
    }


}
