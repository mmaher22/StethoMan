<?php
require "CONN.php";
$myid = urldecode($_POST['patid']);
$docid = urldecode($_POST['docid']);
$out = "REPORT:";
$mysql_qry = "select * FROM report, visit WHERE report.PatientID = '".$myid."' AND visit.PatientID = '".$myid."' AND visit.DoctorID = '".$docid."' ";
$result = mysql_query($mysql_qry);
$count = 0;
while($row_data = mysql_fetch_array($result))
{
  $count = $count + 1;
  $spec = $row_data['Specialization'];
  $desc = $row_data['Description'];
  $tit = $row_data['Title'];
  $time = $row_data['Time'];
  
  $out = $out."$".$tit." at ".$time." - ".$spec."^".$desc;
}

if(!$count) echo "Error: No relation between Doctor and Patient Exists";
else echo $out."$";
?>