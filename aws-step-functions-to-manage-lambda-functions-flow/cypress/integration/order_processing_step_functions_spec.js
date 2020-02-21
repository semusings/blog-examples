describe('Order Processing Step Functions Test', function () {

    it('Complete Order When Inventory Have Sufficient Product Quantity', function () {
        cy.request("POST", Cypress.env('ordersEndpoint'), {
            productId: 1212,
            quantity: 3
        }).then(function (resp) {
            console.log(resp);
            expect(resp.status).to.eq(200)
        })
    });

    it('Not Complete Order When Inventory Have No Sufficient Product Quantity', function () {
        cy.request("POST", Cypress.env('ordersEndpoint'), {
            productId: 1212,
            quantity: 10
        }).then(function (resp) {
            console.log(resp);
            expect(resp.status).to.eq(200)
        })
    });

});