# Chui JMS v334.0
## Info
+ Author
	+ https://github.com/rage123450
+ Environment
	+ JDK 8
	+ Netbeans
	+ MySQL 5.6.12
		+ database名 v327 (ソースコード上で直接指定 v207と被るため)

## 実行方法
+ sqlをimportする
+ JMS v334.0のクライアントを用意する
	+ JMS v334.2だとサーバーとログインサーバーと接続が切れます
		+ packet headerもしくはpacket構造に違いがある模様
+ Netbeansでビルド後run.batを実行

## 注意
+ カンナでログインするとクラッシュします
+ 自動登録処理なし
+ log4j使っているみたいなのでバージョン更新したほうが良さそう(?)