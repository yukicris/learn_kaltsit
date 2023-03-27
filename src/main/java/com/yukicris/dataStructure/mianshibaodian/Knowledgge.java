package com.yukicris.dataStructure.mianshibaodian;

public class Knowledgge {
    // 前序遍历

    /**
     *                  A
     *             B       C
     *           D    E   F  G
     *          H     I
     *
     *        以上面那个为例子.前序就是    "根左右",
     *        第一步 写根  A  B   C
     *        第二步  再写根   A   B(DE)  C(FG)
     *        第三部  再写根   A   B(D'H'  E'I')  C(FG)
     *        排序完成   ABDHEICFG
     */

    // 中序遍历

    /**
     *                  A
     *             B       C
     *           D    E   F  G
     *          H     I
     *
     *        以上面那个为例子.前序就是    "左根右",
     *        第一步 写左根右    B  A   C
     *        第二步  再写根   (D)B(E)  A   (F)C(G)
     *        第三部  再写根   ('H'D)B('I'E)  A   (F)C(G)
     *        排序完成   HDBIEAFCG
     */

    // 后序遍历

    /**
     *                  A
     *             B       C
     *           D    E   F  G
     *          H     I
     *
     *        以上面那个为例子.前序就是    "左右根",
     *        第一步 写左右根    B    C   A
     *        第二步  再写根   (DE)B   (FG)C   A
     *        第三部  再写根   ('H'D'I'E)B   (FG)C   A
     *        排序完成   HDIEBFGCA
     */

}
