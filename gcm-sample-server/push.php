<?php
include_once 'gcm.php';

header('Content-Type: application/json');

$input_data = json_decode(file_get_contents('php://input'), true);

$instance_id = $input_data['instance_id'];
$message = $input_data['message'];

$data = array(
	'errorCode' => 1,
	'errorMessage' => '',
);

if ($instance_id == "" || $message == "") {
	$data['errorMessage'] = 'Invalid input';
	echo json_encode($data);
} else {
	echo pushMessage($instance_id, $message);
}
?>