import zio._
import zio.http._
import zio.http.model.Method
import java.net.InetSocketAddress

object HelloWorld extends ZIOAppDefault {

  val app: HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! / "text" => Response.text("Hello World!")
  }

  val serverLive = ServerConfig.live(
    ServerConfig.default.copy(address =
      new InetSocketAddress(sys.env.getOrElse("PORT", "8080").toInt)
    )
  ) >>> Server.live

  override val run =
    Server
      .serve(app)
      .provide(
        serverLive
      )
}
