package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Attachment;
import nyc.c4q.ramonaharrison.network.HTTPS;
import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.network.response.Response;
import nyc.c4q.ramonaharrison.network.response.SendMessageResponse;
import nyc.c4q.ramonaharrison.util.Token;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Main {
    private final static String JSON_DATA =
            "{"
                    + "  \"geodata\": ["
                    + "    {"
                    + "      \"id\": \"1\","
                    + "      \"name\": \"Julie Sherman\","
                    + "      \"gender\" : \"female\","
                    + "      \"latitude\" : \"37.33774833333334\","
                    + "      \"longitude\" : \"-121.88670166666667\""
                    + "    },"
                    + "    {"
                    + "      \"id\": \"2\","
                    + "      \"name\": \"Johnny Depp\","
                    + "      \"gender\" : \"male\","
                    + "      \"latitude\" : \"37.336453\","
                    + "      \"longitude\" : \"-121.884985\""
                    + "    }"
                    + "  ]"
                    + "}";
    private final static String JsonObject2 =
            "{"
                    +" \"attachment\": ["
                    +"   {"
                    +"      \"fallback\": \"Hello my sunshine\","
                    +"      \"pretext\": \"Rainbow smiles\","
                    +"      \"title\": \"Happiness\","
                    +"      \"title_link\": \"https://usercontent1.hubstatic.com/6295648_f520.jpg\","
                    +"      \"text\": \"Hope this works\","
                    +"      \"color\": \"#7CD197\""
                    +"   }"
                    +" ]"
                    +"}";
    private static JSONObject jObject = null;
    private static JSONObject jObject2 = null;

    public static void main(String[] args) throws JSONException, IOException, ParseException {
//
//        Bot myBot = new Bot();
//
//        myBot.testApi();
//
//        myBot.listChannels();
//
//        myBot.listMessages(Slack.BOTS_CHANNEL_ID);
//
//        myBot.sendMessageToBotsChannel("Trying to send attachments but can't figure it out :P");
//
//        Bot myBotTest = new Bot();
//
//        myBotTest.testApiMyBot();
//
//        myBotTest.listChannelsMyBot();
//
//        myBotTest.listMessagesMyBot(Slack.IM_CHANNEL);
//        System.out.println();


        HttpClient client = HttpClientBuilder.create().build();
        String uRL1="https://hooks.slack.com/services/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";
        String uRL2="https://hooks.slack.com/services/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";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content-type", "application/json");
        jsonObject.put("attachment",JsonObject2);
        jsonObject.put("text", "hello darkness my old friend");
        String uRL3="https://slack.com/api/" + "chat.postMessage" + "?token=" + Token.findApiToken() + "&channel=" + "C7KE0KTM4" + "&attachment=" + jsonObject.get("attachment") + "&as_user=" + "U7K9LUTFC";
        uRL3 = URLEncoder.encode(uRL3, "UTF-8");
        HttpPost post = new HttpPost(uRL3);
        System.out.println(jsonObject.get("content-type"));
        StringEntity postingString = new StringEntity(jsonObject.toString());//gson.tojson() converts your pojo to json
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        JSONObject uRL3Response = HTTPS.get(HTTPS.stringToURL(uRL3));
        Response response = new Response(uRL3Response);
        System.out.println(response.isOk());
        System.out.println(response.getError());



////
//        JSONObject obj = new JSONObject(JsonObject2);
//        System.out.println(obj.toString());
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpPost post = new HttpPost("https://hooks.slack.com/services/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");
//        HttpPost post1 = new HttpPost("https://hooks.slack.com/services/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");
//        StringEntity postingString = new StringEntity(obj.toString());//gson.tojson() converts your pojo to json
//        post.setEntity(postingString);
//        post.setHeader("content-type", "application/x-www-form-urlencoded");
//        post.setHeader("Content-type", "application/json");
//        HttpResponse response = client.execute(post);
        
//        HttpClient client = HttpClientBuilder.create().build();
//        StringEntity posting = new StringEntity(obj.toString());
//        post1.setEntity(posting);
//        post1.addHeader("attachment ", obj.toString());
//        System.out.println(post1);
//        HttpResponse response = client.execute(post1);


//        myBotTest.sendMessageToBotsIMChannel(obj.toString());

//        public static SendMessageResponse sendIMMessageMyBot(String messageText) {
//
//        try {
//            messageText = URLEncoder.encode(messageText, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
//
//        URL sendMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_POST_MESSAGE + "?token=" + API_KEY_MYBOT + "&channel=" + IM_CHANNEL + "&text=" + messageText + "&as_user=" + asUser);
//
//        return new SendMessageResponse(HTTPS.get(sendMessageUrl));
//    }

//        HttpGet request = new HttpGet("https://hooks.slack.com/services/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");
//        HttpResponse response = client.execute(request);
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("content-type", "application/json");
//        System.out.println(jsonObject.get("content-type"));
//        JSONArray attachment = new JSONArray();
//        attachment.put(obj);
//        jsonObject.put("attachment", attachment);
//        obj.put("payload", JsonObject2);
//
//
//
//
//        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//        StringBuffer result = new StringBuffer();
//
//        String line = "";
//        while((line = rd.readLine())!=null){
//            result.append(line);
//            System.out.println("response payload is " + result);
//        }



//        HttpGet request = new HttpGet("https://guessbot.slack.com/messages/D7JQB8HMF/?code=256675766608.256826586913.9a158c253763c703b24bf74f94223e96a4c337cccb040d397904e1922f8f0fff&state=");
//        String sURL = "https://guessbot.slack.com/messages/D7JQB8HMF/?code=256675766608.256826586913.9a158c253763c703b24bf74f94223e96a4c337cccb040d397904e1922f8f0fff&state="; //just a string
//
//        String wURL = "https://hooks.slack.com/services/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";
//        JSONParser jsonParser = new JSONParser();
//        JSONObject object = jsonParser.getJSONFromUrl(wURL);
//        String content=object.getString(Slack.IM_CHANNEL);
//
//        System.out.println(content);
//
//        HttpPost post2 = new HttpPost("https://hooks.slack.com/services/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");
//        StringEntity postingsString = new StringEntity(jsonObject.toString());//gson.tojson() converts your pojo to json
//        post2.setEntity(postingsString);
//        post2.setHeader("Content-type", "application/json");
//        HttpResponse response = client.execute(post2);


//
//        final JSONObject obj = new JSONObject(JSON_DATA);
//        final JSONArray geodata = obj.getJSONArray("geodata");
//        final int n = geodata.length();
//        for (int i = 0; i < n; ++i) {
//            final JSONObject person = geodata.getJSONObject(i);
//            System.out.println(person.getInt("id"));
//            System.out.println(person.getString("name"));
//            System.out.println(person.getString("gender"));
//            System.out.println(person.getDouble("latitude"));
//            System.out.println(person.getDouble("longitude"));
//        }




//
//
//
//
//        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//        StringBuffer result = new StringBuffer();
//
//        String line = "";
//        while((line = rd.readLine())!=null){
//            result.append(line);
//            System.out.println("response payload is " + result);
//        }



//        client.execute("https://hooks.slack.com/services/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");



        // Post "Hello, world!" to the #bots channel
        //myBot.sendMessage("Hello, world!");


//        myBot.sendMessageToBotsChannel("Test");
//        myBot.sendMessageToBotsChannel("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

//        myBot.sendMessageToBotsIMChannel("Test");



//        myBot.sendMessageToBotsChannel("Wayne, Quana, Anas and Tech Tai are in da house!! We in da house!!");


        //I want to see how this works

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

    }
}