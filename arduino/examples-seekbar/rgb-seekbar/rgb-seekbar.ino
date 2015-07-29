#include <ArduinoJson.h>

// Expected JSON message: {"R": 120, "G": 2, "B": 34}

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

    int r = root["R"];
    int g = root["G"];
    int b = root["B"];

    Serial.println(r);
    Serial.println(g);
    Serial.println(b);

    // TODO: Do some stuff
  }  

  delay(100);
}
