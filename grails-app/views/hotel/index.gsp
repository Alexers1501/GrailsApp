<html>
<head>
    <meta name="layout" content="main"/>
    <title>Справочник стран</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Справочник отелей</h1>

        <div>
            <p> Всего ${hotelTotal} отелей в справочнике</p>
            <g:link controller="hotel" action="add">
                Добавить
            </g:link>
        </div>

        <table>
            <tr>
                <th>Название отеля</th>
                <th>Назване страны</th><
                <th>★</th>
                <th>Сайт</th>
            </tr>
            <g:each in="${hotelList}" var="hotel">
                <tr>
                    <td>${hotel.name}</td>
                    <td>${hotel.country.name}</td>
                    <td>${hotel.rate}</td>
                    <td>${hotel.site}</td>
                    <td>
                        <g:link controller="hotel" class = "editButton" action="edit" id="${hotel.id}">
                            Редактировать
                        </g:link>
                        <g:link controller="hotel" action="delete" id="${hotel.id}">
                            Удалить
                        </g:link>
                     </td>
                </tr>
            </g:each>
        </table>


%{--        <form action="/country/updateName" method="post" style="margin: 0 auto; width:320px">--}%
%{--            <input type="text" name="name" value="" id="name"/>--}%
%{--            <input type="submit" name="update name" value="update name" id="update name"/>--}%
%{--        </form>--}%
    </section>
</div>

</body>
</html>