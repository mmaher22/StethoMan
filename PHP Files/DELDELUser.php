<?php
require "CONN.php";

$user_id = urldecode($_POST['myid']);
$user_table = urldecode($_POST['table']);

if($user_table == 'doctor'){
$mysql_qry = "DELETE FROM doctor WHERE DoctorID ='".$user_id."' ";
$mysql_qry2 = "DELETE FROM review WHERE DoctorID ='".$user_id."' ";
$mysql_qry3 = "DELETE FROM timeslot WHERE DoctorID ='".$user_id."' ";
$mysql_qry4 = "DELETE FROM message WHERE fromid ='".$user_id."' OR toid ='".$user_id."' ";
$mysql_qry5 = "DELETE FROM medication WHERE DoctorID ='".$user_id."' ";
$mysql_qry6 = "DELETE FROM report WHERE DoctorID ='".$user_id."' ";
$result = mysql_query($mysql_qry) & mysql_query($mysql_qry2) & mysql_query($mysql_qry3) & mysql_query($mysql_qry4) & mysql_query($mysql_qry5) & mysql_query($mysql_qry6);
}
else{
$mysql_qry = "DELETE FROM patient where PatientID ='".$user_id."' ";
$mysql_qry2 = "DELETE FROM review WHERE PatientID ='".$user_id."' ";
$mysql_qry3 = "DELETE FROM lab WHERE PatientID ='".$user_id."' ";
$mysql_qry4 = "DELETE FROM message WHERE fromid ='".$user_id."' OR toid ='".$user_id."' ";
$mysql_qry5 = "DELETE FROM visit WHERE PatientID ='".$user_id."' ";
$mysql_qry6 = "DELETE FROM medication WHERE PatientID ='".$user_id."' ";
$mysql_qry7 = "DELETE FROM report WHERE PatientID ='".$user_id."' ";
$result = mysql_query($mysql_qry) & mysql_query($mysql_qry2) & mysql_query($mysql_qry3) & mysql_query($mysql_qry4) & mysql_query($mysql_qry5) & mysql_query($mysql_qry6) & mysql_query($mysql_qry7);
}

if($result) {
echo "User Deleted";
}
else
echo "Error: User ID not found";

echo $mysql_qry;

?>	



