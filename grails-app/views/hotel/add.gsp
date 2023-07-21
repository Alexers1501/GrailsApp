<html>
<head>
    <meta name="layout" content="main"/>
    <title>Справочник стран</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Справочник отелей</h1>
        <h2>Добавление отеля</h2>

        <g:form controller="hotel" action="addHotel" method="post"
                style="margin: 0 auto; width:320px">
            <div>
                <label for="name">Название отеля</label>
                <input type="text" name="hotel.name"
                       value="${fieldValue(bean:hotel, field:'name')}"
                       id="name" maxSize="255" required/>
                <br>
                <g:hasErrors bean="${hotel}">
                    <span style="color: red">Название слишком длинное или название уже занято</span>
                </g:hasErrors>
            </div>

            <div>
                <label for="country">Название страны</label>
                <select name="hotel.country.name" id="country" required>
                    <g:each in="${countryList}" var="country">
                        <option>${country.name}</option>
                    </g:each>
                </select>
            </div>

            <div>
                <label for="rate">Количество звезд</label>
                <input type="number" min="1" max="5" value="1" name="hotel.rate" id="rate" required/>
            </div>

            <div>
                <label for="site">Сайт</label>
                <input type="url" name="hotel.site" value="" id="site"/>
            </div>

            <div>
                <input type="submit" name="save" value="Сохранить" id="save"/>
            </div>
        </g:form>
    </section>
</div>

</body>
</html>