package View;

import java.io.File;

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

    private final String file;

    public HtmlContent() {
        this.file = getPath();
    }

    private String getPath() {
        String f = new File("src\\Images\\").getAbsoluteFile().toURI().toString();
        return f;
    }

    public String htmlMsg(String color, String floatMsg, String message, String nomeArquivo, String nomeHashArquivo, String date) {
        String html = "<div style=\"width:100%;color:white;background-color:#color;margin:5px;padding:5px 5px 5px 5px;border:1px solid #48545E;margin-#float:120px;font-size:12px;right:0px;\" > #anexo #message <p style=\"margin-top:-10px;\" align=\"right\"> #date </p> </div>";
        html = html.replace("#color", color);
        html = html.replace("#float", floatMsg);
        html = html.replace("#anexo", ((!nomeArquivo.equals("")) ? htmlAnexo(nomeArquivo, nomeHashArquivo) : ""));
        html = html.replace("#message", message);
        html = html.replace("#date", date);
        return html;
    }

    private boolean isImage(String format) {
        return format.toLowerCase().equals("png") || format.toLowerCase().equals("jpg") || format.toLowerCase().equals("jpge") || format.toLowerCase().equals("gif");
    }

    private boolean isFile(String name, String format) {
        boolean isFile = new File("Files\\Received\\" + format + "\\" + name).isFile();
        return isFile;
    }

    public String htmlAnexo(String nomeArquivo, String nomeHashArquivo) {
        String html = "<div style=\"background-color:rgb(90,90,127);padding:10px 5px 10px 7px;border:1px solid white;\"> #img <a href=\"file:/#path\" style=\"color:white;font-size:12px;text-decoration:none;\" > #fileName </a> </div>";
        String fileName = nomeHashArquivo;
        String format = fileName.split("[.]")[1];
        html = html.replace("#path", fileName);
        String name = nomeArquivo + "." + format;
        String filePath = new File("Files\\Received\\" + format + "\\").getAbsoluteFile().toURI().toString();
        if (isImage(format)) {
            if (!isFile(name, format)) {
                html = html.replace("#fileName", ((name.length() > 20) ? name.substring(0, 20) + "..." : name));
                html = html.replace("#img", "<img src='" + file + "/imageIcon.png' height=\"16\" />");
            } else {
                html = "<div style=\"background-color:rgb(90,90,127);border:1px solid white;\"> <img src='" + filePath + "/" + name + "' width=\"240\" /> </div>";
            }
        } else {
            html = html.replace("#fileName", ((name.length() > 20) ? name.substring(0, 20) + "..." : name));
            html = html.replace("#img", "<img src='" + file + "/filesIcon.png' width=\"16\" />");
        }
        return html;
    }

}
