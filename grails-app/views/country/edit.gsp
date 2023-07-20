<html>
<head>
    <meta name="layout" content="main"/>
    <title>Справочник стран</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Справочник стран</h1>
        <h2>Реадктирование данных о стране</h2>

        <form action="/country/updateCountry" method="post" style="margin: 0 auto; width:320px">
            <label for="name">Название страны</label>
            <input type="text" name="name" value="" id="name"/>

            <label for="capital">Название столицы</label>
            <input type="text" name="capital" value="" id="capital"/>
            <input type="submit" name="update name" value="update name" id="update name"/>
        </form>
    </section>
</div>

</body>
</html>