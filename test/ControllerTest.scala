import controllers.Controller
import play.api.test._


class ControllerTest extends PlaySpecification {

  "respond to the index Action" in new WithApplication {
    val controller = app.injector.instanceOf[Controller]
    val result = controller.index()(FakeRequest())

    status(result) must equalTo(OK)

  }


  "respond to the /atmlocation Action when passed a test-name" in new WithApplication {
    val controller = app.injector.instanceOf[Controller]
    val testCity="TestCity"
    val result = controller.atmLocation(testCity)(FakeRequest())
    status(result) must equalTo(OK)
    contentType(result) must beSome("text/html")
    contentAsString(result) must contain("No ING ATM(s) found in TestCity")
  }

  "respond to the /atmlocation Action when passed a valid city name" in new WithApplication {
    val controller = app.injector.instanceOf[Controller]
    val testCity="amsterdam"
    val result = controller.atmLocation(testCity)(FakeRequest())
    status(result) must equalTo(OK)
    contentType(result) must beSome("text/html")
    contentAsString(result) must contain("ING ATM(s) within Amsterdam")
  }







}


