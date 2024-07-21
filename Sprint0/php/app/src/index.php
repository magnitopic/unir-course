<?php
function saveUserData($name, $age, $description) {
    // Save name and description to name.txt
    $content = "Name: $name\nDescription: $description\n";
    file_put_contents("name.txt", $content, FILE_APPEND);

    // Save age to age.txt
    file_put_contents("age.txt", $age . "\n", FILE_APPEND);
}

function calculateAverageAge() {
    $ages = file("age.txt", FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    $sum = array_sum($ages);
    $count = count($ages);
    return $count > 0 ? $sum / $count : 0;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST['name'] ?? 'No name provided';
    $age = $_POST['age'] ?? 'No age provided';
    $description = $_POST['description'] ?? 'No description provided';

    saveUserData($name, $age, $description);
    $averageAge = calculateAverageAge();
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>User Information Form</title>
</head>
<body>
    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age"><br>
        <label for="description">Description:</label><br>
        <textarea id="description" name="description"></textarea><br>
        <input type="submit" value="Submit">
    </form>
    <?php if ($_SERVER["REQUEST_METHOD"] == "POST"): ?>
        <p>Average Age of Users: <?= htmlspecialchars($averageAge) ?></p>
    <?php endif; ?>
</body>
</html>