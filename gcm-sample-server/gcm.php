<?php

class GCM {

	//put your code here
	// constructor
	function __construct() {

	}

	/**
	 * Sending Push Notification
	 */
	public function send_notification($registatoin_ids, $message) {
		// Set POST variables
		$url = 'https://fcm.googleapis.com/fcm/send';

		$fields = array(
			'registration_ids' => $registatoin_ids,
			'data' => $message,
		);

		$headers = array(
			'Authorization: key=' . "AAAA-6gqXZQ:APA91bHJ6qqI283ITfkbWnuzVwA6eUUAJh-jde0Y13EZliSo7r9thVD0wn2p4mJt29Ejz0_7pkz1ELZQ_SvGZQGKe2XxmMk7LH27exi2GX9x-MLjivKEsaPaCOTIpMha244DJCYLjw3h",
			'Content-Type: application/json',
		);
		// Open connection
		$ch = curl_init();

		// Set the url, number of POST vars, POST data
		curl_setopt($ch, CURLOPT_URL, $url);

		curl_setopt($ch, CURLOPT_POST, true);
		curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

		// Disabling SSL Certificate support temporarily
		curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);

		curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));

		// Execute post
		$result = curl_exec($ch);
		if ($result === FALSE) {
			die('Curl failed: ' . curl_error($ch));
		}

		// Close connection
		curl_close($ch);
		return $result;
	}
}

function pushMessage($regCode, $message) {
	if (isset($regCode) && isset($message)) {
		$regId = $regCode;

		$gcm = new GCM();

		$registatoin_ids = array($regId);
		$message = array("message" => $message);

		$result = $gcm->send_notification($registatoin_ids, $message);

		return $result;
	}
}
?>