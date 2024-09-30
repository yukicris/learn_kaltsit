package com.yukicris.unitMyself.fileNameChange;

import java.util.regex.Pattern;

public class ChineseMatch {
    /**
     * 中文匹配
     * @param args
     */
    public static void main(String[] args) {
        String str = " \"星乃 一歌 | 星乃 一歌\" > <\n" +
                "  \"天馬 咲希 | 天马 咲希\" > <\n" +
                "  \"望月 穂波 | 望月 穗波\" > <\n" +
                "  \"日野森 志歩 | 日野森 志步\" >\n" +
                "  \"花里 みのり | 花里 实乃里\" >\n" +
                "  \"桐谷 遥 | 桐谷 遥\" > < d\n" +
                "  \"桃井 愛莉 | 桃井 爱莉\" > <\n" +
                "  \"日野森 雫 | 日野森 雫\" > <\n" +
                "  \"小豆沢 こはね | 小豆泽 心羽\"\n" +
                "  \"白石 杏 | 白石 杏\" > < d\n" +
                "  \"鳳 えむ | 凤 笑梦\" > < d\n" +
                "  \"草薙 寧々 | 草薙 宁宁\" > <\n" +
                "  \"宵崎 奏 | 宵崎 奏\" > < d\n" +
                "  \"朝比奈 まふゆ | 朝比奈 真冬\"\n" +
                "  \"東雲 絵名 | 东云 绘名\" > <\n" +
                "  \"暁山 瑞希 | 晓山 瑞希\" > <\n" +
                "  \"初音 ミク | 初音 未来\" > <\n" +
                "  \"鏡音 リン | 镜音 铃\" > <\n" +
                "  \"巡音 ルカ | 巡音 流歌\" > <\n" +
                "  \"MEIKO\" >";
        String chStr = "";
        Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
        for (int i = 0; i < str.length(); i++) {
            String ss = String.valueOf(str.charAt(i));
            if (pattern.matcher(ss).matches()){
                chStr = chStr+ss;
            }
        }
        System.out.print(""+chStr);
    }
}
