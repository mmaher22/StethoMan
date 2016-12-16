<?php
require "CONN.php";
//$user_ID=urldecode($_POST['myid']);
//$user_ID=1;


$mysql_qry = "SELECT PatientID, Name, Mail, Mobile, Address, ImgURL, Blood, notes from patient  WHERE PatientID =2";

mysql_select_db('patient');

$retval = mysql_query( $mysql_qry, $connect );
if(! $retval )
{
 die('Could not find data: ' . mysql_error());
}
$j=0;
  // Fetch one and one row
  while ($row=mysql_fetch_row($retval))
    {

    printf ("%s (%s)\n",$row[0],$row[1]);
    printf ("%s (%s)\n",$row[2],$row[3]);
    printf ("%s (%s)\n",$row[4],$row[5]);
    printf ("%s (%s)\n",$row[6],$row[7]);

    }
  // Free result set
  mysql_free_result($result);


echo "Patient found successfully\n";
mysql_close($connect);



?>	
