Feature: Bookings for my guests
  In order to take control of reservations at the hotel,
  As an hotel owner,
  I want to create reservations for my guests.

  Scenario Outline: create a normal booking
    Given "<Firstname>" "<Lastname>" is a tourist in Guatemala
    And needs lodging on the date "<checkIn>" to "<checkOut>"
    But the room must include "<AdditionalNeeds>"
    When owner create the booking
    Then the system confirm booking with status code <StatusCode>
    And Total Price less than $ <TotalPrice>
    Examples:
      | Firstname | Lastname | checkIn    | checkOut   | AdditionalNeeds | StatusCode | TotalPrice |
      | Javier    | Chin     | 2022-04-11 | 2022-04-15 | jacuzzi         | 200        | 170        |
      | Guillermo | Lopez    | 2022-04-16 | 2022-04-18 | None            | 200        | 150        |