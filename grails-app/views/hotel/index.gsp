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
            <g:form controller="hotel" action="searchHotelsByFilter" method="post">
                <label for="filterName">Поиск</label>
                <input type="text" name="filterName" value="${filterParams.filterName}" id="filterName"/>

                <label for="countryName">Название страны</label>
                <select name="countryName" value="${filterParams.countryName}" id="countryName">
                    <option  value="Любая">Любая</option>
                    <g:each in="${countryList}" var="country">
                        <option
                            <g:if test="${filterParams.countryName==country.name}">selected</g:if>
                        >${country.name}
                        </option>
                    </g:each>
                </select>

                <input type="submit" value="Найти"/>
            </g:form>
        </div>

        <div>
            <p> ${messageCountHotels}</p>
            <g:link controller="hotel" action="add">
                Добавить
            </g:link>
        </div>

        <g:paginate controller="hotel" action="searchHotelsByFilter"
                    params="${params}"
                    total="${hotelList.totalCount}"/>
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

    </section>
</div>

</body>
</html>