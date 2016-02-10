package helpers

import play.api.test.{Helpers, FakeApplication, WithApplication}

class FoodApp extends WithApplication(FakeApplication(additionalConfiguration = Helpers.inMemoryDatabase()))
