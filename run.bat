@echo off
set MS_VERSION=334
set MS_SUBVERSION=0
set WZ_XML_PATH=wz\
@title いばらサーバー v%MS_VERSION%.%MS_SUBVERSION%
set CLASSPATH=.;bin\*
java -server -Dnet.sf.odinms.wzpath=%WZ_XML_PATH% -Djavax.net.ssl.keyStore=filename.keystore -Djavax.net.ssl.keyStorePassword=passwd -Djavax.net.ssl.trustStore=filename.keystore -Djavax.net.ssl.trustStorePassword=passwd net.swordie.ms.Server %MS_VERSION% %MS_SUBVERSION%
pause
