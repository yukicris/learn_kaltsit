package com.yukicris.springCloud.day3;

public class git_敲命令指南 {
    /**
     *
     yewei@DESKTOP-6824VCP MINGW64 /f/workList_2/springcloud-config (main)
  1   $ git add .

     yewei@DESKTOP-6824VCP MINGW64 /f/workList_2/springcloud-config (main)
  2   $ git status (查看更新状态,此处为application.yml)
     On branch main
     Your branch is up to date with 'origin/main'.

     Changes to be committed:
     (use "git restore --staged <file>..." to unstage)
     new file:   application.yml


     yewei@DESKTOP-6824VCP MINGW64 /f/workList_2/springcloud-config (main)
  3   $ git commit -m "first commit"(信息)
     [main 849a2e5] first commit
     1 file changed, 15 insertions(+)
     create mode 100644 application.yml

     yewei@DESKTOP-6824VCP MINGW64 /f/workList_2/springcloud-config (main)
  4   $ git push origin(当前用户) main(主分支)
     Enumerating objects: 4, done.
     Counting objects: 100% (4/4), done.
     Delta compression using up to 8 threads
     Compressing objects: 100% (3/3), done.
     Writing objects: 100% (3/3), 371 bytes | 371.00 KiB/s, done.
     Total 3 (delta 0), reused 0 (delta 0), pack-reused 0
     To https://github.com/yukicris/springcloud-config.git
     46818f4..849a2e5  main -> main

     */
}
