#include <ArduinoJson.h>

// Expected JSON message: {"volume": 120}

String json;
StaticJsonBuffer<200> jsonBuffer;

void setup() {
  Serial.begin(9600);
}

void loop() {
  
  if (Serial.available() > 0) {

    json = Serial.readString(); 

    JsonObject& root = jsonBuffer.parseObject(json);

    if (!root.success()) {
      Serial.println("Error parsing json message");
      return;
    }

    Serial.print("json: ");
    Serial.println(json);

    int volume = root["volume"];

    Serial.println(volume);

    // TODO: Do some stuff
  }  

  delay(100);
}
