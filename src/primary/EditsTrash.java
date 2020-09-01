package primary;

public class EditsTrash {

	public EditsTrash() {}
	
	public void addToPopulationList() {
		for(int i = 0; i<3; i++) {
			Person person = new Person();
			person.id = i;
			Trash.populationList.add(person);
		}
	}
	
	public void editList() {
		Trash.populationList.get(0).id = 999;
	}
	
	public void printList() {
		for(Person person: Trash.populationList) {
			System.out.println(person.toStringMinimal());
		}
	}

}