curl http://10.1.247.207:5000/set \
    -H "Content-Type: application/json" \
    -X POST \
    -d '
    {
        "type":2002,
        "ids": ["r", "g", "b"],
        "action": {
            "connection": "http",
            "uris": ["http://192.168.1.12:3000"],
            "include_in_message": {
                "type": 701
            }
        }
    }' 



curl http://192.168.1.10:5000/set \
    -H "Content-Type: application/json" \
    -X POST \
    -d '
    {
        "type":701,
        "r":127,
        "g":178,
        "b":229
    }' 

curl http://10.1.247.207:5000/set \
    -H "Content-Type: application/json" \
    -X POST \
    -d '
    {
        "type":2002,
        "ids": ["r", "g", "b"],
        "action": {
            "connection": "http",
            "uris": ["http://192.168.1.10:5000/set"],
            "include_in_message": {
                "type": 701
            }
        }
    }' 

curl http://10.1.247.207:5000/set \
    -H "Content-Type: application/json" \
    -X POST \
    -d '
    {
        "type":2002,
        "ids": ["r", "g", "b"],
        "action": {
            "connection": "http",
            "uris": ["http://192.168.1.10:5000/set",
                     "http://192.168.1.16:5000/set"],
            "include_in_message": {
                "type": 701
            }
        }
    }' 

###---

curl http://192.168.0.105:5000/set \
    -H "Content-Type: application/json" \
    -X POST \
    -d '
    {
        "type":2002,
        "ids": ["r", "g", "b"],
        "action": {
            "connection": "http",
            "uris": ["http://192.168.0.104:5000/set",
                     "http://192.168.0.106:5000/set"],
            "include_in_message": {
                "type": 701
            }
        }
    }'     


curl http://10.1.247.207:5000/set \
    -H "Content-Type: application/json" \
    -X POST \
    -d '
    {
        "type":1000, 
        "milliseconds":100
    }' 

