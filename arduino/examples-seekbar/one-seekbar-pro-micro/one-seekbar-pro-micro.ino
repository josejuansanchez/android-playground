#include <ArduinoJson.h>

/*
  Expected JSON message: {"light": 120}

  References: 
  - https://learn.sparkfun.com/tutorials/pro-micro--fio-v3-hookup-guide/example-1-blinkies
 */

int RXLED = 17; 

void setup() {
  Serial.begin(9600);

  pinMode(RXLED, OUTPUT);  // Set RX LED as an output
  // TX LED is set as an output behind the scenes  
}

void loop() {
  
  if (Serial.available() > 0) {

    String json = Serial.readString(); 
    StaticJsonBuffer<200> jsonBuffer;
    JsonObject& root = jsonBuffer.parseObject(json);

    if (!root.success()) {
      Serial.println("Error parsing json message");
      return;
    }

    Serial.print("json: ");
    Serial.println(json);

    int light = root["light"];

    Serial.println(light);

    // TODO: Do some stuff
    if (light < 50) {
       digitalWrite(RXLED, LOW);
       TXLED0;
    } else {
       digitalWrite(RXLED, HIGH);
       TXLED1;
    }
  }  

  delay(100);
}
