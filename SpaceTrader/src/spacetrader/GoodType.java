 /* it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package spacetrader;

/**
 *
 * @author Kristen Lawrence
 */
public enum GoodType {
    WATER (0),
    FOOD (1),
    FUR (2),
    ORE (3),
    GAMES (4),
    FIREARMS (5),
    MEDICINE (6),
    MACHINES (7),
    NARCOTICS (8),
    ROBOTS (9);
    
    private final int key;

    GoodType(int keyNum) {
        this.key = keyNum;
    }
    private int key() {
        return key;
    }   
}