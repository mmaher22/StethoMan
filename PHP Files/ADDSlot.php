<?php
require "CONN.php";

$time = urldecode($_POST['timestamp']);
$maxpat = urldecode($_POST['maxpat']);
$docid = urldecode($_POST['docid']);

$mysql_qry = "INSERT INTO timeslot ( Time, MaxPatients, DoctorID)
VALUES ( '".$time."', '".$maxpat."', '".$docid."' )";

$result = mysql_query($mysql_qry);
if ($result) $error = "Time Slot is Added";
else $error = "Error: ".mysql_error();


echo $error; 
?>	