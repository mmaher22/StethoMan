<?php
require "CONN.php";
$myid = urldecode($_POST['myid']);

$out = "MSG:";
$mysql_qry = "select * FROM message WHERE toid = '0' ";
$result = mysql_query($mysql_qry);

while($row_data = mysql_fetch_array($result))
{
  $from = $row_data['fromid'];
  $fromtype = $row_data['fromtype'];
  if($fromtype == 'patient'){
    $qry = "SELECT Name FROM patient WHERE PatientID = '".$from."' ";
    $result2 = mysql_query($qry);
    while($row_data2 = mysql_fetch_array($result2)) $name = $row_data2['Name'];
    $fromname = 'Pat: '.$name." (".$from.")";

  }
  else{
    $qry = "SELECT Name FROM doctor WHERE DoctorID = '".$from."' ";
    $result2 = mysql_query($qry);
    while($row_data2 = mysql_fetch_array($result2)) $name = $row_data2['Name'];
    $fromname = 'Dr: '.$name." (".$from.")";
  }
  $msg = $row_data['content']; 
  $time = $row_data['time'];
  
  $out = $out.";".$fromname." At: ".$time."$".$msg;
}
echo $out.";";
?>