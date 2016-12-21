<?php
require "CONN.php";

$out = "USER";
$mysql_qry = "select * from doctor ";
$result = mysql_query($mysql_qry) ;

while($row_data = mysql_fetch_array($result))
{
  $name = $row_data['Name'];
  $id = $row_data['DoctorID'];
  $out = $out."-".$name." (doctor) ID: ".$id;
}

$mysql_qry = "select * from patient";
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