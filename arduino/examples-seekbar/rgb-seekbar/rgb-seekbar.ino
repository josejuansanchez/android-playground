#include <ArduinoJson.h>

// Expected JSON message: {"r": 120, "g": 2, "b": 34}

#define RPIN 8
#define GPIN 9
#define BPIN 10

void setup() {
  Serial.begin(9600);

  pinMode(RPIN, OUTPUT);
  pinMode(GPIN, OUTPUT);
  pinMode(BPIN, OUTPUT);
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

    int r = root["r"];
    int g = root["g"];
    int b = root["b"];

    Serial.println(r);
    Serial.println(g);
    Serial.println(b);

    analogWrite(RPIN, r);
    analogWrite(GPIN, g);
    analogWrite(BPIN, b);
  }  

  delay(100);
}
