+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
2011-11-30 10:51:50,311 | INFO  | qtp556795987-107 | HelloWorld                       | eptor.AbstractLoggingInterceptor  178 |  -  -  | Inbound Message
----------------------------
ID: 1
Address: http://localhost:9000/services/HelloWorld
Encoding: UTF-8
Http-Method: POST
Content-Type: text/xml;charset=UTF-8
Headers: {accept-encoding=[gzip,deflate], Content-Length=[1011], content-type=[text/xml;charset=UTF-8], Host=[localhost:9000], SOAPAction=[""], User-Agent=[Jakarta Commons-HttpClient/3.1]}
Payload: <soapenv:Envelope xmlns:cxf="http://cxf.camel.demos.mycompany.com/" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header><wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"><wsse:UsernameToken wsu:Id="UsernameToken-1" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"><wsse:Username>testuser</wsse:Username><wsse:Password Type="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest">WsieFP1Kj+qSKm6VyAhZeEPBJHU=</wsse:Password><wsse:Nonce EncodingType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary">UhaM20jCwsGyZNvkm6Nvyw==</wsse:Nonce><wsu:Created>2011-11-30T05:21:49.817Z</wsu:Created></wsse:UsernameToken></wsse:Security></soapenv:Header>
   <soapenv:Body>
      <cxf:greet>
         <!--Optional:-->
         <name>Chaks</name>
      </cxf:greet>
   </soapenv:Body>
</soapenv:Envelope>
--------------------------------------
2011-11-30 10:51:50,735 | WARN  | qtp556795987-107 | WSS4JInInterceptor               | ecurity.wss4j.WSS4JInInterceptor  465 |  -  -  | No security action was defined!
2011-11-30 10:51:50,765 | WARN  | qtp556795987-107 | PhaseInterceptorChain            | ache.cxf.common.logging.LogUtils  372 |  -  -  | Interceptor for {http://cxf.camel.demos.mycompany.com/}HelloWorldService has thrown exception, unwinding now
org.apache.cxf.binding.soap.SoapFault: No security action was defined!
	at org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor.getAction(WSS4JInInterceptor.java:466)[140:org.apache.cxf.bundle:2.5.0]
	at org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor.handleMessage(WSS4JInInterceptor.java:225)[140:org.apache.cxf.bundle:2.5.0]
	at org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor.handleMessage(WSS4JInInterceptor.java:85)[140:org.apache.cxf.bundle:2.5.0]
	at org.apache.cxf.phase.PhaseInterceptorChain.doIntercept(PhaseInterceptorChain.java:263)[140:org.apache.cxf.bundle:2.5.0]
	at org.apache.cxf.transport.ChainInitiationObserver.onMessage(ChainInitiationObserver.java:123)[140:org.apache.cxf.bundle:2.5.0]
	at org.apache.cxf.transport.http_jetty.JettyHTTPDestination.serviceRequest(JettyHTTPDestination.java:323)[140:org.apache.cxf.bundle:2.5.0]
	at org.apache.cxf.transport.http_jetty.JettyHTTPDestination.doService(JettyHTTPDestination.java:289)[140:org.apache.cxf.bundle:2.5.0]
	at org.apache.cxf.transport.http_jetty.JettyHTTPHandler.handle(JettyHTTPHandler.java:72)[140:org.apache.cxf.bundle:2.5.0]
	at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:939)[62:org.eclipse.jetty.server:7.4.5.v20110725]
	at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:875)[62:org.eclipse.jetty.server:7.4.5.v20110725]
	at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:117)[62:org.eclipse.jetty.server:7.4.5.v20110725]
	at org.eclipse.jetty.server.handler.ContextHandlerCollection.handle(ContextHandlerCollection.java:247)[62:org.eclipse.jetty.server:7.4.5.v20110725]
	at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:110)[62:org.eclipse.jetty.server:7.4.5.v20110725]
	at org.eclipse.jetty.server.Server.handle(Server.java:346)[62:org.eclipse.jetty.server:7.4.5.v20110725]
	at org.eclipse.jetty.server.HttpConnection.handleRequest(HttpConnection.java:589)[62:org.eclipse.jetty.server:7.4.5.v20110725]
	at org.eclipse.jetty.server.HttpConnection$RequestHandler.content(HttpConnection.java:1065)[62:org.eclipse.jetty.server:7.4.5.v20110725]
	at org.eclipse.jetty.http.HttpParser.parseNext(HttpParser.java:823)[58:org.eclipse.jetty.http:7.4.5.v20110725]
	at org.eclipse.jetty.http.HttpParser.parseAvailable(HttpParser.java:220)[58:org.eclipse.jetty.http:7.4.5.v20110725]
	at org.eclipse.jetty.server.HttpConnection.handle(HttpConnection.java:411)[62:org.eclipse.jetty.server:7.4.5.v20110725]
	at org.eclipse.jetty.io.nio.SelectChannelEndPoint.handle(SelectChannelEndPoint.java:535)[57:org.eclipse.jetty.io:7.4.5.v20110725]
	at org.eclipse.jetty.io.nio.SelectChannelEndPoint$1.run(SelectChannelEndPoint.java:40)[57:org.eclipse.jetty.io:7.4.5.v20110725]
	at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:529)[56:org.eclipse.jetty.util:7.4.5.v20110725]
	at java.lang.Thread.run(Thread.java:662)[:1.6.0_29]


+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++