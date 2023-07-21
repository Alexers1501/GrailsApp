<html>
<head>
    <meta name="layout" content="main"/>
    <title>Справочник отелей</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">

        <h1>Справочник отелей</h1>

        <div class="outer-container">

            <div>
                <g:form controller="hotel" class="filter-container" action="searchByCatalogPage" method="post">
                    <div>
                        <label for="filterName">Поиск</label>
                        <input type="text" name="filterName" value="${filterParams.filterName}" id="filterName"/>
                    </div>

                    <div>
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
                    </div>
                    <div>
                        <input type="submit" value="Найти"/>
                    </div>
                </g:form>
            </div>

            <div>
                <p> ${messageCountHotels}</p>
            </div>

            <div>
                <g:link class="button-link" controller="hotel" action="add">
                    + Добавить отель
                </g:link>
            </div>

            <div class="page-numbers">
                <g:paginate controller="hotel" action="searchByCatalogPage"
                            params="${params}"
                            total="${hotelList.totalCount}"/>
            </div>

            <g:if test="${hotelList.totalCount > 0}">

                <table>
                    <tr>
                        <th>Название отеля</th>
                        <th>★</th>
                        <th>Назване страны</th>
                        <th>Действие</th>
                    </tr>
                    <g:each in="${hotelList}" var="hotel">
                        <tr>
                            <td>
                                ${hotel.name}
                                <g:if test="${(hotel.site)}">
                                    <br>
                                    <a href="${hotel.site}" target="_blank">Перейти на сайт</a>
                                </g:if>
                            </td>
                            <td>
                                <g:each in="${1..hotel.rate}">
                                    ★
                                </g:each>
                            </td>
                            <td>${hotel.country.name}</td>
                            <td>
                                <g:link class="button-link" controller="hotel" action="edit" id="${hotel.id}">
                                    Редактировать
                                </g:link>
                                <br>
                                <g:link class="button-link" controller="hotel" action="delete" id="${hotel.id}">
                                    Удалить
                                </g:link>
                            </td>
                        </tr>
                    </g:each>
                </table>

            </g:if>
        </div>

    </section>
</div>

</body>
</html>