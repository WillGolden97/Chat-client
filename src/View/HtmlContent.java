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

    private final String fileIcon;
    private final String audioIcon;
    private final String imageIcon;

    public HtmlContent() {
        this.audioIcon = "audioIcon.png";
        this.imageIcon = "imageIcon.png";
        this.fileIcon = "filesIcon.png";
    }

    public String htmlMsg(String color, String floatMsg, int id, String message, String nomeArquivo, String nomeHashArquivo, String date) {
        String html = "<div style=\"width:100%;color:white;background-color:#color;margin:5px;padding:#topPadding 5px 5px 5px;border:1px solid #48545E;margin-#float:120px;font-size:12px;right:0px;\" > #delete #anexo #message <p style=\"margin-top:-10px;\" align=\"right\"> #date </p> </div> ";
        String delete = "";
        String topPadding = "5";
        if (floatMsg.equals("left")) {
            delete = "<div align=\"right\" style=\"padding:0px 0px 3px 0px;\" > <a href=\"file:/" + id + "\" style=\"color:white;font-size:8px;text-decoration:none;\" > ••• </a></div>";
            topPadding = "0";
        }
        html = html.replace("#topPadding", topPadding);
        html = html.replace("#delete", delete);
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

    private boolean isAudio(String format) {
        return format.toLowerCase().equals("ogg") || format.toLowerCase().equals("wav") || format.toLowerCase().equals("mp3");
    }

    private boolean isFile(String name, String format) {
        String fileFormat = format.split("[.]")[1];
        String hash = format.split("[.]")[0];
        boolean isFile = new File("Files\\Received\\" + fileFormat + "\\" + hash + "\\" + name).isFile();
        return isFile;
    }

    private String midiaAttachment(String html, String name, String format) {
        String icon = fileIcon;
        String path = new File("Images\\").getAbsoluteFile().toURI().toString();
        boolean isAudio = format.toLowerCase().equals("ogg") || format.toLowerCase().equals("wav") || format.toLowerCase().equals("mp3");
        boolean isImage = format.toLowerCase().equals("png") || format.toLowerCase().equals("jpg") || format.toLowerCase().equals("jpge") || format.toLowerCase().equals("gif");
        if (isAudio) {
            icon = audioIcon;
        } else if (isImage) {
            icon = imageIcon;
        }
        html = html.replace("#img", "<img src=\"" + path + icon + "\" height=\"16\" />");
        html = html.replace("#fileName", ((name.length() > 20) ? name.substring(0, 20) + "..." : name));
        return html;
    }

    public String htmlAnexo(String nomeArquivo, String nomeHashArquivo) {
        String html = "<div style=\"background-color:rgb(90,90,127);padding:10px 5px 10px 7px;border:1px solid white;\"> #img <a href=\"file:/#name/#hashName\" style=\"color:white;font-size:12px;text-decoration:none;\" > #fileName </a> </div>";
        String hashName = nomeHashArquivo;
        String hash = hashName.split("[.]")[0];
        String format = hashName.split("[.]")[1];
        String name = nomeArquivo + "." + format;
        html = html.replace("#name", name);
        html = html.replace("#hashName", hashName);

        String filePath = new File("Files\\Received\\" + format + "\\" + hash + "\\").getAbsoluteFile().toURI().toString();
        if (isFile(name, hashName) && isImage(format)) {
            html = "<div style=\"background-color:rgb(90,90,127);border:1px solid white;\"><center> <img src='" + filePath + "/" + name + "' width=\"260\" /> </center></div>";
        } else {
            html = midiaAttachment(html, name, format);
        }
        return html;
    }

}
