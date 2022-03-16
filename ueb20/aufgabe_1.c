#include <stdio.h>
 
void main() {
    float nettopreis;
    printf("Bitte geben Sie den Nettobetrag in Euro ein: \n");
    scanf("%f", &nettopreis);
    float mwsteuer = nettopreis * .2f;
    float bruttopreis = nettopreis + mwsteuer;
    float skonto = bruttopreis * .02f;
    float rechnungsbetrag = bruttopreis - skonto;
 
    printf("Nettopreis \t\tEuro %.2f\n"
        "+ 20%% MwSt \t\tEuro %.2f\n"
        "=====================================\n"
        "Bruttopreis \t\tEuro %.2f\n"
        "- 2%% Skonto \t\tEuro %.2f\n"
        "=====================================\n"
        "Rechnungsbetrag \tEuro %.2f\n", 
        nettopreis, mwsteuer, bruttopreis, 
        skonto, rechnungsbetrag);
}