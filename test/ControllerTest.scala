import controllers.Controller
import org.junit.Assert.{assertEquals, assertTrue}
import org.junit.Test
import play.api.mvc.{Results, _}
import play.api.test.Helpers._
import play.api.test._
import play.mvc.Http.Status.OK
import play.test.Helpers._

import scala.concurrent.Future



class ControllerTest  extends PlaySpec with Results {




  "Example Page#index" should {
    "should be valid" in {
      val controller = new Controller()
      val result: Future[Result] = controller.index().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe "ok"
    }
  }

}


