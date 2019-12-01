import java.io.Serializable

import javax.enterprise.context.{ApplicationScoped, RequestScoped, SessionScoped}
import javax.faces.push.{Push, PushContext}
import javax.faces.view.ViewScoped
import javax.inject._

import scala.beans.BeanProperty
import javax.websocket.Endpoint
import javax.websocket.EndpointConfig
import javax.websocket.Session
import javax.websocket.server.ServerEndpoint

@Named
@ViewScoped
class WebsocketMB extends Serializable{

    @Inject
    @Push(channel = "echo")
    private var push:PushContext = _

    @BeanProperty
    var text:String = ""

    def echo = {
        println(s"Echo message >> $text")
        push.send(text)
    }

}
