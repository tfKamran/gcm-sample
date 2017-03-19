# GCM/FCM Sample

A basic reusable implementation of GCM/FCM push messaging.

## Test

You can test your setup with:

    curl -X POST -H "Content-Type: application/json" -d '{
                "instance_id":"<YOUR_DEVICE_FCM_TOKEN>",
                "message":"Here"
            }' "http://localhost/push.php"

Just copy paste the sample code from this repo and you'll be ready with the latest GCM/FCM implementation.

## Collaborate

If you find this implementation old, you can feel free to contribute.
