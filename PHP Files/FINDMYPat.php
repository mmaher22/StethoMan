<?php
require "CONN.php";

$userid = urldecode($_POST['myid']);

$out = "MYPAT";
$mysql_qry = "SELECT patient.PatientID, Name FROM patient, visit WHERE patient.PatientID = visit.PatientID AND visit.DoctorID = '".$userid."' ";
$result = mysql_query($mysql_qry) ;

while($row_data = mysql_fetch_array($result))
{
  $name = $row_data['Name'];
  $id = $row_data['PatientID'];
  $out = $out."-".$name." (patient) ID: ".$id;
}

$out = $out."-";
echo $out;
?>	