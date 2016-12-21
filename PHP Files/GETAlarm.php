<?php
require "CONN.php";
$myid = urldecode($_POST['myid']);

$out = "ALARM:";
$mysql_qry = "SELECT * FROM medication WHERE PatientID = '".$myid."' AND isRead = '0' "; 
$result = mysql_query($mysql_qry);

while($row_data = mysql_fetch_array($result))
{
  $medname = $row_data['Name'];
  $stime = $row_data['StartTime']; 
  $times = $row_data['NumberOfTimes'];
  $interval = $row_data['Period'];
  $out = $out."/".$medname."+".$stime."+".$times."+".$interval;
}
$out = $out."/";

$mysql_qry = "UPDATE medication SET isRead = '1' WHERE PatientID = '".$myid."'"; 
$result = mysql_query($mysql_qry) ;

echo $out;
?>	