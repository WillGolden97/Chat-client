package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class HtmlContent {
    private String styles (String color) {
        return "color:white;background-color:"+color+";margin:5px;padding:5px 5px 5px 5px;border:1px solid #48545E;border-radius:10px;";
    }
    
    public String imgContact (String color,String from,String url,String date) {
        return 
        "<div style=\"width:164px;background-color:"+color+";margin:5px;\" >"+
            "<h3 style=\"margin-top:0px;font-size:8px;\">@"
                +from+""+
            "</h3>"        
                +"<img src=\""+url+"\" width=\"200\" />"+ 
            "<p style=\"margin-top:-10px;margin-right:5px;\" align=\"right\">"
                +date+
            "</p>"+
        "</div>";        
    } 
    
    public String imgReply (String color,String url,String date) {
        return 
        "<div style=\"width:164px;background-color:"+color+";margin:5px;\" >"     
           +"<img src=\""+url+"\" width=\"200\" />"+ 
            "<p style=\"margin-top:-10px;margin-right:5px;\" align=\"right\">"
                +date+
            "</p>"+
        "</div>";        
    } 

    public String HtmlReplyMsg(String color,String message,String date) {
        return 
        "<div style=\"width:100%;"+styles(color)+"margin-left:50px;right:0px;\" >"
            +message+
            "<p style=\"margin-top:-10px;\" align=\"right\">"
                +date+
            "</p>"+
         "</div>";
    }
    
    public String HtmlContactMsg(String color,String from,String message,String date) {
        return 
        "<div style=\"width:100%;"+styles(color)+"margin-right:50px;right:0px;\" >"
            +message+
            "<p style=\"margin-top:-10px;\" align=\"right\">"
                +date+
            "</p>"+
         "</div>";           
    }    

}
