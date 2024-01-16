# set the directory path to the folder that contains the files
$dir_path = "C:\Users\Jax\Downloads\PastPapers"

# get all the files in the directory
$files = Get-ChildItem $dir_path -File

$Dictionary=@{
"WAC" = "Accounting"
"WPH" = "Physics"
"WBI" = "Biology"
"WCH" = "Chemistry"
"WMA" = "Mathematics"
"WST" = "Statistics"
"WPS" = "Psychology"
}

# loop through each file
foreach ($file in $files) {

    # extract the "Unit", "Type", and "Date" from the file name

    $formatted = $file.BaseName.ToUpper().Replace("_", "-").Replace("RMS", "MSC").Replace("-01", "")

    if (($formatted -match "UNUSED") -or ($formatted -match "SPEC")) {
        $other_folder = Join-Path $dir_path "OTHERS"
        if (-not (Test-Path $other_folder)) {
            New-Item $other_folder -ItemType Directory | Out-Null
        }
        Copy-Item -Path $file.FullName -Destination $(Join-Path $other_folder $file.Name)
    } else {
        $subject = $formatted.Substring(0, 3)

        if($Dictionary.ContainsKey($subject)) {
            $subject = $Dictionary[$subject]
        }

        $unit = $formatted.Substring(4, 1)
        $type = $formatted.Split("-")[1]
        $date = $formatted.Split("-")[2]
        $month = $($date.Substring(4,2))
        $year = $($date.Substring(0,4))
        if ($type -eq "MSC") {
            $month = [int]$month - 2
        }
        if ([int]$month -lt 4 -and [int]$month -gt 0) {
            $month = "Jan"
        } elseif ([int]$month -ge 4 -and [int]$month -lt 8) { 
            $month = "June"
        } elseif ([int]$month -lt 0 -or [int]$month -ge 8) {
            if ([int]$month -lt 0) {
                $year = [int]$year - 1
            }
            $month = "Oct"
        }
    
        Write-Output "$formatted || $date [$type, $year, $month]"

        $subject_folder = Join-Path $dir_path $subject
        $unit_folder = Join-Path $subject_folder "Unit $unit"
        $type_folder = Join-Path $unit_folder $type
        
        if (-not (Test-Path $subject_folder)) {
            New-Item $subject_folder -ItemType Directory | Out-Null
        }
        if (-not (Test-Path $unit_folder)) {
            New-Item $unit_folder -ItemType Directory | Out-Null
        }

        $new_name = "Unit $unit-$year-$month"
        if ($type -eq "MSC") {
            $new_file_path = Join-Path $type_folder "$new_name$($file.Extension)"
            if (-not (Test-Path $type_folder)) {
                New-Item $type_folder -ItemType Directory | Out-Null
            }
        } else {
            $new_file_path = Join-Path $unit_folder "$new_name$($file.Extension)"
        }
        Copy-Item -Path $file.FullName -Destination $new_file_path
    }
}
