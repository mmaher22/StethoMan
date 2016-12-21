<?php
require "CONN.php";

$docid = urldecode($_POST['docid']);
$slotid = urldecode($_POST['slotid']);
$patid = urldecode($_POST['patid']);

$error = "";

$mysql_qry = "select * from visit where PatientID ='".$patid."' AND DoctorID='".$docid."' AND SlotID = '".$slotid."' ";
$result = mysql_query($mysql_qry) ;
if(mysql_num_rows($result) > 0) $error = "Error: You have registered before at this slot";


if (empty($error))
{
$mysql_qry = "INSERT INTO visit ( SlotID, DoctorID, PatientID)
VALUES ( '".$slotid."', '".$docid."', '".$patid."')";
$result = mysql_query($mysql_qry) ;

$mysql_qry = "SELECT MaxPatients FROM timeslot WHERE SlotID = '".$slotid."' ";
$result = mysql_query($mysql_qry) ;
$row = mysql_fetch_row($result);
$maxi = $row[0] - 1;

if($row[0] == 1) $mysql_qry = "UPDATE timeslot SET MaxPatients = '".$maxi."', Isavailable = '0' WHERE SlotID = '".$slotid."' ";
else $mysql_qry = "UPDATE timeslot SET MaxPatients = '".$maxi."' WHERE SlotID = '".$slotid."' ";

$result = mysql_query($mysql_qry) ;

if(!$result) echo "Error: No Connection With Database ".mysql_error();
}

echo $error; 
?>	