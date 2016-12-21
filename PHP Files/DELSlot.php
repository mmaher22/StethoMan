<?php
require "CONN.php";

$slotid = urldecode($_POST['slotid']);

//Text message
$mysql_qry = "SELECT Time FROM timeslot WHERE SlotID = '".$slotid."' ";
$result = mysql_query($mysql_qry);
$time = mysql_fetch_row($result);
$msg = "We are sorry that your visit on".$time."has been cancelled due to outstanding circumstances";
$fromid = 0;

//Send apology to patients at this slot
$mysql_qry0 = "SELECT PatientID FROM visit WHERE SlotID = '".$slotid."' ";
$result = mysql_query($mysql_qry0);
while($row_data = mysql_fetch_array($result))
{
  $toid = $row_data['PatientID'];
  $mysql_qry0 = "INSERT INTO message ( toid, fromid, content, fromtype, totype) VALUES ( '".$toid."', '".$fromid."', '".$msg."', 'Manager', 'Patient' )";
  $result2 = mysql_query($mysql_qry0);
}

//Delete Slot
$mysql_qry1 = "DELETE FROM timeslot WHERE SlotID = '".$slotid."' ";
$mysql_qry2 = "DELETE FROM visit WHERE SlotID = '".$slotid."' ";
echo $mysql_qry1;
$result = mysql_query($mysql_qry1) & mysql_query($mysql_qry2);

if ($result) $error = "Time Slot is Deleted";
else $error = "Error: ".mysql_error();

echo $error; 
?>		