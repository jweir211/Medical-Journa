
public class ProfessionalNode {

	public String name;
	public String profession;
	public String office;
	public DiaryTree newTree;
	
	public ProfessionalNode() {
		name = null;
		profession = null;
		office = null;
		newTree = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public DiaryTree getNewTree() {
		return newTree;
	}

	public void setNewTree(DiaryTree newTree) {
		this.newTree = newTree;
	}
	
	
}
