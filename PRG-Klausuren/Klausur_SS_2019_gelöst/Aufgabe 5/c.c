typedef struct {
	char name[50];
	struct {
		int d, m, y;
	} birthdate;
	char sex;
	struct {
		char street[50];
		int houseNumber;
		int postcode;
		char city[50];
	} adress;
} Person;
