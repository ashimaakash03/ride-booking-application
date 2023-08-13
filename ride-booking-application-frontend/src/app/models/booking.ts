export class Booking {
	id: number;
	pickuplocation: string;
	droplocation: string;
	vehicletype: string;
	distancetravelled: number;
	costofride: number;

	constructor(id: number, pickuplocation: string, droplocation: string,
				vehicletype: string, distancetravelled: number, costofride: number) {
		this.id = id;
		this.pickuplocation = pickuplocation;
		this.droplocation = droplocation;
		this.vehicletype = vehicletype;
		this.distancetravelled = distancetravelled;
		this.costofride = costofride;
	}
}
